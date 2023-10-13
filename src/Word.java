public class Word {
    private String word_target; // tu tieng anh
    private String word_explain; // nghia tieng viet

    public Word( String word_target, String word_explain) {
        this.word_explain = word_explain.trim().toLowerCase();
        this.word_target = word_target.trim().toLowerCase();
    }

    public String getWord_Target() {
        return word_target;
    }

    public void setWord_Target(String word_target){
        this.word_target = word_target;
    }

    public String getWord_Explain() {
        return word_explain;
    }

    public void setWord_Explain(String word_explain){
        this.word_explain = word_explain;
    }


}
