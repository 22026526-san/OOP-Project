import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();

    // kiem tra xem tu co nam trong list hay k
    public int checkList(int top, int bot, String word_target) {
        if (top <= bot) {
            int mid = (top + bot) / 2;
            Word word = words.get(mid);

            // hàm compareTo so sánh hai chuôi theo thứ tự từ điển trả về âm , 0,
            //  dương tương ứng lớn hơn bằng bé hơn
            int index = word.getWord_Target().compareTo(word_target);
            if (index == 0)
                return mid;
            if (index > 0) {
                return checkList(top, mid - 1, word_target);
            }
            return checkList(mid + 1, bot, word_target);
        }
        return -1;
    }

//them tu vao list
    public void addWord(Word word) {
        int n = words.size();
        if (checkList(0, n - 1, word.getWord_Target()) == -1) {
            words.add(word);
        } else {
            Word words = lookup(word.getWord_Target());
            System.out.println("This word is already in the Dictionary, its meaning is : " + words.getWord_Explain());
        }
    }

    // tim tu trong list
    public Word lookup(String word_target) {
        int n = words.size();
        int i = checkList(0, n - 1, word_target);
        if (i != -1)
            return words.get(i);
        return null;
    }

    // in ra list cac tu co tien to giong tu da cho (tu da cho nam trong tu dien) co
    // trong list . vd : book -> bookbindery,bookcase,bookbinder...
    public ArrayList<Word> searcher(String word_target) {
        ArrayList<Word> sr = new ArrayList<>();
            // in ra list cac tu co tien to giong tu da cho (tu da cho k nam trong tu dien)
            // co trong list . vd : tra ->
            // transport, translate,transform, transit,....
            for (Word word : words) {
                if (word.getWord_Target().startsWith(word_target)) {
                    sr.add(word);
                }
            }
            return sr;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }
}
