package com.luongdinh.productservice.service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public interface FileStoreService {
    public void upload(String path, String fileName, Optional<Map<String, String>> optionalMetaData,
            InputStream inputStream);

    public byte[] download(String path, String key);
}
