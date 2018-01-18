package imageviewer.control;

import imageviewer.ui.ImageDisplay;

public class NextImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public String name() {
        return "⇨";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.currentImage().next());
    }
}