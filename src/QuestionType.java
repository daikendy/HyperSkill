public interface QuestionType{
    String[] getQuestions();
    String[][] getOptions(); // returns null for T/F type or empty array
    String[] getAnswer();
    boolean hasOptions();
}

class GeneralMCQ implements QuestionType {
    final private String[] questions;
    final private String[][] options;
    final private String[] answer;

    public GeneralMCQ() {
        this.questions = new String[]{
            "What is the capital of France?\n",
            "What is the largest planet in our solar system?\n",
            "What is the boiling point of water at sea level in Celsius?\n",
            "What is the main ingredient in guacamole?",
            "What is the chemical formula for table salt?",
            "Which country is known as the Land of the Rising Sun?",
            "What is the hardest natural substance on Earth?",
            "What is the primary language spoken in Brazil?"
        };
        this.options = new String[][]{
            {"A. Paris", "B. London", "C. Berlin", "D. Madrid"},
            {"A. Earth", "B. Jupiter", "C. Saturn", "D. Mars"},
            {"A. 50°C", "B. 100°C", "C. 0°C", "D. 25°C"},
            {"A. Avocado", "B. Tomato", "C. Onion", "D. Pepper"},
            {"A. NaCl", "B. KCl", "C. CaCO3", "D. H2O"},
            {"A. China", "B. Japan", "C. Korea", "D. Thailand"},
            {"A. Diamond", "B. Gold", "C. Silver", "D. Iron"},
            {"A. Spanish", "B. Portuguese", "C. French", "D. English"}
        };
        this.answer = new String[]{"A", "B", "B", "A", "A", "B", "A", "B"};
    }

    @Override
    public String[] getQuestions() {
        return questions.clone();
    }

    @Override
    public String[][] getOptions() {
        String[][] copy = new String[options.length][];
        for (int i = 0; i < options.length; i++) {
            copy[i] = options[i].clone();
        }
        return copy;
    }

    @Override
    public String[] getAnswer() {
        return answer.clone();
    }
    @Override
    public boolean hasOptions() {
        return options != null && options.length > 0 && options[0].length > 0;
    }
}
class MultipleChoiceQuestion implements QuestionType {
    final private String[] questions;
    final private String[][] options;
    final private String[] answer;

    public MultipleChoiceQuestion() {
        this.questions = new String[]{
        "What is the chemical symbol for gold?\n", 
        "Which organ is responsible for pumping blood throughout the human body?\n", 
        "What gas do plants absorb from the atmosphere for photosynthesis?\n",
        "What is the powerhouse of the cell?",
        "What is H2O commonly known as",
        "Which planet is known as the \"Red Planet\"?",
        "Which part of the atom has a positive charge?",
        "What gas do animals breathe in for survival?",
        };
        this.options = new String[][]{
            {"A. Au", "B. Ag", "C. Pb", "D. Fe"},
            {"A. Heart", "B. Brain", "C. Lungs", "D. Kidneys"},
            {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"},
            {"A. Mitochondria", "B. Nucleus", "C. Ribosome", "D. Endoplasmic Reticulum"},
            {"A. Water", "B. Salt", "C. Sugar", "D. Alcohol"},
            {"A. Mars", "B. Venus", "C. Jupiter", "D. Saturn"},
            {"A. Proton", "B. Neutron", "C. Electron", "D. Nucleus"},
            {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"}
        };
        this.answer = new String[]{"A", "C", "C", "C", "B", "C", "B", "C"};
    }
    @Override
    public String[] getQuestions() {
        return questions.clone();
    }
    @Override
    public String[][] getOptions() {
        String[][] copy = new String[options.length][];
        for (int i = 0; i < options.length; i++) {
            copy[i] = options[i].clone();
        }
        return copy;
    }
    @Override
    public String[] getAnswer() {
        return answer.clone();
    }
    @Override
    public boolean hasOptions() {
        return options != null && options.length > 0 && options[0].length > 0;
    }
}
class TrueOrFalseQuestion implements QuestionType {
    final private String[] questions;
    final private String[] answer;

    public TrueOrFalseQuestion() {
        this.questions = new String[]{
            "The Earth revolves around the Sun.",
            "Water boils at 100°C at sea level.",
            "Sound travels faster in air than in water.",
            "Humans share approximately 60% of their DNA with bananas.",
            "The chemical symbol for iron is Fe.",
            "Plants produce oxygen during photosynthesis.",
            "Electric current is measured in volts.",
            "The ozone layer protects Earth from harmful ultraviolet radiation."
        };
        this.answer = new String[]{"T", "T", "F", "T", "T", "T", "T", "T"};
    }

    @Override
    public String[] getQuestions() {
        return questions.clone();
    }

    @Override
    public String[][] getOptions() {
        return new String[0][0]; // No options for True/False questions
    }

    @Override
    public String[] getAnswer() {
        return answer.clone();
    }
    @Override
    public boolean hasOptions() {
        return false; // True/False questions do not have options
    }
}

