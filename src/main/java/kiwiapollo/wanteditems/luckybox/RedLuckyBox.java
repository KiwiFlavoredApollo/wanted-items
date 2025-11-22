package kiwiapollo.wanteditems.luckybox;

public class RedLuckyBox extends LuckyBox {
    public static final ItemFactory FACTORY = new ItemFactory();

    public RedLuckyBox() {
        super(FACTORY);
    }

    public static class ItemFactory extends LuckyBox.ItemFactory {
        public ItemFactory() {
            super("red_lucky_box");
        }
    }
}
