/**
 * Created by jp on 2/9/14.
 */
public class ListeSimple extends ListeBase implements IListeSimple {

    public ListeSimple(int i) {
        Cell first = new Cell(i);
        setFirst(first);
    }

    @Override
    public void insertQueue(int i) {
        Cell temp = this.getFirst();
        if (temp == null) {
            this.setFirst(new Cell(i));
            return;
        }
        else{
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Cell (i));
        }
    }

    @Override
    public void insertHead(int i) {
        Cell tmp = new Cell(i);
        tmp.setNext(this.getFirst());
        this.setFirst(tmp);
    }

}
