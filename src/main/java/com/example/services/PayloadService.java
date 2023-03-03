package com.example.services;

import com.example.exceptions.StorageException;
import com.example.models.Payload;
import com.example.utils.StorageClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
public class PayloadService {

    @Inject
    StorageClient storageClient;

    public void sendObjectToStorage(Payload payload, File file) throws StorageException {
        try {
            UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                    .bucket("teste")
                    .object(payload.fileName)
                    .filename(file.getAbsolutePath())
                    .contentType("application/pdf")
                    .build();
            ObjectWriteResponse response = storageClient.getMinioClient().uploadObject(uploadObjectArgs);
            System.out.println(response.versionId());
        } catch (Exception e) {
            throw new StorageException("Error upload file to storage. Please try again");
        }
    }


}
