package org.example.frontend;

import org.example.frontend.FrameVichfizFullScreen;

import java.awt.*;
import java.io.File;

public class FrameWithFile extends FrameVichfizFullScreen {
    private File file;
    public FrameWithFile(String title) throws HeadlessException {
        super(title);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
