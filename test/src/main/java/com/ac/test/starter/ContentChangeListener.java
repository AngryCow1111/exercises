package com.ac.test.starter;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ContentChangeListener
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2021/1/26
 */
public class ContentChangeListener extends AbstractMessageSource implements ResourceLoaderAware {

    private static final String PATH = "content.properties";

    private ExecutorService executorService;

    private final static String ENCODING = "UTF-8";

    private Resource messageResource;

    private ResourceLoader resourceLoader = null;

    private Properties messageProperties;

    public ContentChangeListener() {
        this.messageResource = getMessagePropertiesResource();
        this.executorService = Executors.newSingleThreadExecutor();
        messageProperties = loadMessageProperties();
        onChange();
    }


    private void onChange() {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            WatchService watchService = fileSystem.newWatchService();
            File file = this.messageResource.getFile();
            if (file.isFile()) {
                Path path = Paths.get(file.getParent());
                path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
                doHandleChange(watchService);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private Properties loadMessageProperties() {
        EncodedResource encodedResource = new EncodedResource(this.messageResource, ENCODING);
        Properties properties = new Properties();
        try (Reader reader = encodedResource.getReader()) {
            properties.load(reader);
        } catch (Exception e) {

        }
        return properties;
    }

    private Resource getMessagePropertiesResource() {
        ResourceLoader resourceLoader = getResourceLoader();
        return resourceLoader.getResource(PATH);
    }

    public static void main(String[] args) throws IOException {

        ContentChangeListener contentChangeListener = new ContentChangeListener();
        String name = contentChangeListener.getMessage("name", new Object[]{}, Locale.getDefault());
        System.out.println(name);
    }

    private ResourceLoader getResourceLoader() {
        if (resourceLoader == null) {
            return new DefaultResourceLoader();
        }

        return resourceLoader;
    }

    private void doHandleChange(WatchService watchService) {
        executorService.submit(() -> {
            WatchKey take = null;
            try {

                for (; ; ) {
                    take = watchService.take();
                    if (take.isValid()) {
                        List<WatchEvent<?>> watchEvents = take.pollEvents();
                        for (WatchEvent<?> watchEvent : watchEvents) {
                            Watchable watchable = take.watchable();
                            System.out.println("watchable " + watchable);
                            System.out.println(watchEvent);
                            Path path = (Path) watchEvent.context();
                            System.out.println(path);
                        }
                    }

                }
            } catch (Exception e) {

            } finally {
                take.reset();
            }
        });

    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String property = messageProperties.getProperty(code);
        if (StringUtils.hasText(property)) {
            return new MessageFormat(property, locale);
        }
        return null;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
