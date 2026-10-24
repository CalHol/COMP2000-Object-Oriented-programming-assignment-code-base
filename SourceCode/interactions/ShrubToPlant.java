public class ShrubToPlant {
    public void convertShrub(Shrub shrub) {
        if (shrub != null && shrub.getGrowth() >= 10) {
            shrub.grow();
        }
    }
}