package MallPack.Database;

public class DataConnection {
    private static ItemFunc itemf;

    public static ItemFunc getItemFunc() {
        if (itemf == null) {
            itemf = new ItemFunc();
        }
        return itemf;
    }
}
