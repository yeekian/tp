package tutorlink.storage;

import tutorlink.exceptions.StorageOperationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    protected static final String READ_DELIMITER = " \\| ";
    protected static final String WRITE_DELIMITER = " | ";

    public final Path path;

    public Storage(String filePath) throws StorageOperationException {
        path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new StorageOperationException("Error while creating file: " + path);
        }
    }

}
