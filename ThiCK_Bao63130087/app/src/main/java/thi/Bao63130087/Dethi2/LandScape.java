package thi.Bao63130087.Dethi2;

public class LandScape {
    private String landscapeName;
    private String landscapeDiachi;
    private String landscapeImage;

    public LandScape(String landscapeName, String landscapeDiachi, String landscapeImage) {
        this.landscapeName = landscapeName;
        this.landscapeDiachi = landscapeDiachi;
        this.landscapeImage = landscapeImage;
    }

    public String getLandscapeDiachi() {
        return landscapeDiachi;
    }

    public void setLandscapeDiachi(String landscapeDiachi) {
        this.landscapeDiachi = landscapeDiachi;
    }

    public String getLandscapeName() {
        return landscapeName;
    }

    public void setLandscapeName(String landscapeName) {
        this.landscapeName = landscapeName;
    }

    public String getLandscapeImage() {
        return landscapeImage;
    }

    public void setLandscapeImage(String landscapeImage) {
        this.landscapeImage = landscapeImage;
    }
}
