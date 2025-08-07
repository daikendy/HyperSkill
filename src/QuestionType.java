public interface QuestionType{
    String[] getQuestions();
    String[][] getOptions(); // returns null for T/F type or empty array
    String[] getAnswer();
    boolean hasOptions();
}

class MultipleChoiceQuestion implements QuestionType {
    final private String[] questions;
    final private String[][] options;
    final private String[] answer;

    public MultipleChoiceQuestion(String[] questions, String[][] options, String[] answer) {
        this.questions = questions;
        this.options = options;
        this.answer = answer;
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

class GeneralMCQ extends MultipleChoiceQuestion {
    public GeneralMCQ(){
        super(
        new String[]{
            "What is the capital of France?\n",
            "What is the largest planet in our solar system?\n",
            "What is the boiling point of water at sea level in Celsius?\n",
            "What is the main ingredient in guacamole?",
            "What is the chemical formula for table salt?",
            "Which country is known as the Land of the Rising Sun?",
            "What is the hardest natural substance on Earth?",
            "What is the primary language spoken in Brazil?"
            },
        new String[][]{
            {"A. Paris", "B. London", "C. Berlin", "D. Madrid"},
            {"A. Earth", "B. Jupiter", "C. Saturn", "D. Mars"},
            {"A. 50°C", "B. 100°C", "C. 0°C", "D. 25°C"},
            {"A. Avocado", "B. Tomato", "C. Onion", "D. Pepper"},
            {"A. NaCl", "B. KCl", "C. CaCO3", "D. H2O"},
            {"A. China", "B. Japan", "C. Korea", "D. Thailand"},
            {"A. Diamond", "B. Gold", "C. Silver", "D. Iron"},
            {"A. Spanish", "B. Portuguese", "C. French", "D. English"}
            },
        new String[]{
            "A", "B", "B", "A", "A", "B", "A", "B"
            }
        );
    }
}

class MCQScience extends MultipleChoiceQuestion {
    public MCQScience() {
        super(
        new String[]
        {
            "What is the chemical symbol for gold?\n", 
            "Which organ is responsible for pumping blood throughout the human body?\n", 
            "What gas do plants absorb from the atmosphere for photosynthesis?\n",
            "What is the powerhouse of the cell?",
            "What is H2O commonly known as",
            "Which planet is known as the \"Red Planet\"?",
            "Which part of the atom has a positive charge?",
            "What gas do animals breathe in for survival?"
        },
        new String[][]
        {
            {"A. Au", "B. Ag", "C. Pb", "D. Fe"},
            {"A. Heart", "B. Brain", "C. Lungs", "D. Kidneys"},
            {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"},
            {"A. Mitochondria", "B. Nucleus", "C. Ribosome", "D. Endoplasmic Reticulum"},
            {"A. Water", "B. Salt", "C. Sugar", "D. Alcohol"},
            {"A. Mars", "B. Venus", "C. Jupiter", "D. Saturn"},
            {"A. Proton", "B. Neutron", "C. Electron", "D. Nucleus"},
            {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"}
        },
        new String[]
            {"A", "A", "B", "A", "A", "A", "A", "A" }
        );
    }
}

class MCQGeography extends MultipleChoiceQuestion{
    
    public MCQGeography() {
        super(
            new String[]{
                "What is the longest river in the world?\n",
                "Which country has the largest land area?\n",
                "What is the capital city of Canada?\n",
                "Which desert is the largest in the world by area?\n",
                "Mount Everest is located on the border of which two countries?\n",
                "Which continent has the most countries?\n",
                "What is the smallest country in the world by land area?\n",
                "Which ocean is the deepest?\n"
            },
            new String[][]{
                {"A. Nile", "B. Amazon", "C. Yangtze", "D. Mississippi"},
                {"A. China", "B. Canada", "C. Russia", "D. United States"},
                {"A. Toronto", "B. Ottawa", "C. Vancouver", "D. Montreal"},
                {"A. Arabian", "B. Gobi", "C. Antarctic", "D. Sahara"},   
                {"A. China and India", "B. India and Nepal", "C. Nepal and Tibet", "D. China and Nepal"},
                {"A. Asia", "B. Africa", "C. Europe", "D. South America"},
                {"A. Vatican City", "B. Monaco", "C. San Marino", "D. Liechtenstein"},
                {"A. Atlantic Ocean", "B. Pacific Ocean", "C. Indian Ocean", "D. Arctic Ocean"}
            },
            new String[]{
                "A", "C", "B", "C", "D", "B", "A", "B" 
            }
        );
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

