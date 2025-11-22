package kiwiapollo.wanteditems.luckybox;

public class GreenLuckyBox extends LuckyBox {
    public static final ItemFactory FACTORY = new ItemFactory();

    public GreenLuckyBox() {
        super(FACTORY);
    }

    public static class ItemFactory extends LuckyBox.ItemFactory {
        public ItemFactory() {
            super("green_lucky_box");
        }
    }
}
