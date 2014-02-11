/**
 * Created by jp on 2/9/14.
 */
public class ListeOrdonnee extends ListeBase implements IListeOrdonnee {

    public ListeOrdonnee(int i) {
        setFirst(new Cell(i));
    }

    @Override
    public void insert(int i) {
        Cell newc = new Cell(i);
        Cell temp = this.getFirst();

        if (temp == null) {
            this.setFirst(newc);
            return;
        }
        if(temp.getValue() > i) {
            newc.setNext(temp);
            this.setFirst(newc);
            return;
        }

        while (temp != null && temp.getNext() != null) {
            if(temp.getNext().getValue() > i) {
                newc.setNext(temp.getNext());
                temp.setNext(newc);
                return;
            } else {
                temp = temp.getNext();
            }
        }
        if (temp != null) {
            temp.setNext(newc);
        }
        newc.setNext(null);
    }

    @Override
    public void fusion(ListeOrdonnee  lIsteOrdonneeBis) {
        Cell temp = this.getFirst();
        Cell temp_bis = lIsteOrdonneeBis.getFirst();

        if (temp == null) {
            this.setFirst(temp_bis);
            return;
        }

        if (temp_bis.getValue() < temp.getValue()) {
            Cell next = temp_bis.getNext();

            temp_bis.setNext(temp.getNext());
            this.setFirst(temp_bis);

            temp_bis = next;
        }

        while (temp.getNext() != null && temp_bis != null) {
            if (temp_bis.getValue() < temp.getNext().getValue()) {
                Cell next = temp_bis.getNext();

                temp_bis.setNext(temp.getNext());
                temp.setNext(temp_bis);

                temp_bis = next;
            } else {
                temp = temp.getNext();
            }
        }
    }

}
