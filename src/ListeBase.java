/**
 * Created by jp on 2/9/14.
 */
public abstract class ListeBase implements IListeBase{

    private Cell first;

    public Cell getFirst() {
        return first;
    }

    public void setFirst(Cell first) {
        this.first = first;
    }

    @Override
    public int size() {
        int cpt = 0;
        Cell tmp = this.first;
        while (tmp != null){
            cpt++;
            tmp = tmp.getNext();
        }
        return cpt;

    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        String S = "Liste Simple : ";
        Cell tmp = getFirst();
        while(tmp.getNext() != null)
        {
            S += tmp.toString();
            tmp = tmp.getNext();
        }
        return S + "null";
    }

    static class Cell  {
        private int value;
        private Cell next = null;

        public Cell(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Cell getNext() {
            return next;
        }

        public void setNext(Cell next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value + " --> ";
        }
    }


    public static void main(String[] args) {
        ListeSimple ListeS = new ListeSimple(1);
        for (int i = 0; i < 8; ++i){
            ListeS.insertQueue(i+2);
        }
        ListeS.insertHead(0);
        System.out.println(ListeS.toString());
        System.out.println("Calcul de la taille : " + ListeS.size());

        System.out.println("-----------");
        ListeOrdonnee ListeO = new ListeOrdonnee(1);
        for (int i = 0; i < 8; ++i){
            ListeO.insert(i + 2);
        }
        System.out.println(ListeO.toString());
    }


}
