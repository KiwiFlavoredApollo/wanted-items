package kiwiapollo.wanteditems.luckybox;

public class BlueLuckyBox extends LuckyBox {
    public static final ItemFactory FACTORY = new ItemFactory();

    public BlueLuckyBox() {
        super(FACTORY);
    }

    public static class ItemFactory extends LuckyBox.ItemFactory {
        public ItemFactory() {
            super("blue_lucky_box");
        }
    }
}
