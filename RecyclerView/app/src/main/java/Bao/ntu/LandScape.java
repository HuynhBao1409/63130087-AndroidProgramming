package Bao.ntu;

public class LandScape {
    String landimgFileName;
    String landCaption;

    public LandScape(String landimgFileName, String landCaption) {
        this.landimgFileName = landimgFileName;
        this.landCaption = landCaption;
    }

    public String getLandimgFileName() {
        return landimgFileName;
    }

    public void setLandimgFileName(String landimgFileName) {
        this.landimgFileName = landimgFileName;
    }

    public String getLandCaption() {
        return landCaption;
    }

    public void setLandCaption(String landCaption) {
        this.landCaption = landCaption;
    }
}
