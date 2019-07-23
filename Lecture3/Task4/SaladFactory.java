public class SaladFactory {

    public MySalad getSalad(SaladTypes type) {
        MySalad toReturn = null;
        switch (type) {
            case GREEK:
                toReturn = new GreekSalad();
                break;
            case VEGAN:
                toReturn = new VeganSalad();
                break;
            case CHEESE:
                toReturn = new CheeseSalad();
                break;
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return toReturn;
    }
}
