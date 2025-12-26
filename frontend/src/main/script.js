// 1. CONSTANTS & STATE (Memory)
// Change this to your Render/Railway URL when you deploy!
const API_BASE_URL = "https://quizmaster-sh0j.onrender.com/api/quiz";
let currentQuestions = []; // Stores the 5 questions from Java
let currentQuestionIndex = 0;
let score = 0;
let quizCategory = ""; // To track what we are playing

// 2. DOM ELEMENTS (The "Tools" from the video)
// We grab these once so we don't have to search for them every time
const homeScreen = document.getElementById("home-screen");
const quizScreen = document.getElementById("quiz-screen");
const resultScreen = document.getElementById("result-screen");

const progressBar = document.getElementById("progress-bar");
const questionCountText = document.getElementById("question-count");
const questionText = document.getElementById("question-text");
const optionsContainer = document.getElementById("options-container");
const finalScoreText = document.getElementById("final-score");
const scorePercentage = document.getElementById("score-percentage");
// Add these with your other variables
let timerInterval; // Stores the "Clock" ID so we can stop it
let timeLeft = 15; // Seconds per question
const timerText = document.getElementById("timer");

// 3. EVENT LISTENERS (The Interaction)
// This listens for clicks on the 4 category cards on the Home Screen
document.querySelectorAll(".quiz-card").forEach(card => {
    card.addEventListener("click", () => {
        const type = card.getAttribute("data-type"); // Get "McqScience", etc.
        startQuiz(type);
    });
});

document.getElementById("restart-btn").addEventListener("click", restartApp);
document.getElementById("home-btn").addEventListener("click", restartApp);


// Map the "ugly" database names to "pretty" screen names
const categoryTitles = {
    "McqScience": "Science Challenge",
    "McqGeography": "World Geography",
    "GeneralMCQ": "General Knowledge",
    "TrueOrFalse": "Fact or Fiction"
};

// 4. CORE FUNCTIONS (The Logic)

// FUNCTION A: Start the Game (Fetch API + Async/Await)
async function startQuiz(type) {

    // 1. UPDATE TITLE DYNAMICALLY
    // If the map has a name, use it. Otherwise, default to "Quiz".
    const prettyTitle = categoryTitles[type] || "Quiz Challenge";
    document.getElementById("category-title").innerText = prettyTitle;
    
    // UI: Show loading state
    homeScreen.classList.add("hidden");
    quizScreen.classList.remove("hidden");
    questionText.innerText = "Loading questions from Java...";
    
    quizCategory = type;
    score = 0;
    currentQuestionIndex = 0;

    try {
        // FETCH: Calling your Spring Boot Backend
        const response = await fetch(`${API_BASE_URL}/start?type=${type}`);
        
        if (!response.ok) throw new Error("Failed to connect to backend");

        // DATA: Convert JSON string back to JavaScript Array
        currentQuestions = await response.json();
        
        // UI: Show the first question
        showQuestion();

    } catch (error) {
        console.error(error);
        questionText.innerText = "Error: Could not load questions. Is backend running?";
    }
}

// FUNCTION B: Show One Question (DOM Manipulation)
function showQuestion() {
    const question = currentQuestions[currentQuestionIndex];
    // ADD THIS AT THE BOTTOM of showQuestion
    startTimer();

    // 1. Update Progress Bar (e.g., 20%, 40%)
    const progressPercent = ((currentQuestionIndex + 1) / currentQuestions.length) * 100;
    progressBar.style.width = `${progressPercent}%`;

    // 2. Update Text
    questionCountText.innerText = `Question ${currentQuestionIndex + 1}/${currentQuestions.length}`;
    questionText.innerText = question.questions; // Ensure this matches your Java JSON key!

    // NEW LOGIC STARTS HERE
    let options = [];

    // Check if we are playing True/False or normal MCQ
    if (quizCategory === "TrueOrFalse") {
        // Force specific options for T/F
        options = [
            { label: "T", text: "True" },
            { label: "F", text: "False" }
        ];
    } else {
        // Standard behavior for Science, Geo, etc.
        options = [
            { label: "A", text: question.options_a },
            { label: "B", text: question.options_b },
            { label: "C", text: question.options_c },
            { label: "D", text: question.options_d }
        ];
    }

    // 3. Create Buttons dynamically
    optionsContainer.innerHTML = ""; // Clear old buttons
    

    // options.forEach(opt => {
    //     const btn = document.createElement("button");
    //     btn.classList.add("option-btn");
    //     btn.innerText = `${opt.label}) ${opt.text}`;
        
    //     // Add Click Event to check answer
    //     // ✅ CORRECT (Sends "D")
    //     btn.addEventListener("click", () => handleAnswer(opt.label, question.answer));
        
    //     optionsContainer.appendChild(btn);
    // });
    // 3. Create Buttons dynamically (This part stays mostly the same)
    optionsContainer.innerHTML = ""; 
    
    options.forEach(opt => {
        const btn = document.createElement("button");
        btn.classList.add("option-btn");
        
        // VISUAL TWEAK: For T/F, just show "True" (not "T) True")
        if (quizCategory === "TrueOrFalse") {
            btn.innerText = opt.text;
        } else {
            btn.innerText = `${opt.label}) ${opt.text}`;
        }
        
        // CRITICAL: This ensures we send "T" or "F" to match your DB
        btn.addEventListener("click", () => handleAnswer(opt.label, question.answer));
        
        optionsContainer.appendChild(btn);
    });
}

function startTimer() {
    timeLeft = 15; // Reset to 15 seconds
    timerText.innerText = `⏱️ ${timeLeft}`;
    
    // Clear any existing timer just in case
    clearInterval(timerInterval);

    // Start a new loop that runs every 1000ms (1 second)
    timerInterval = setInterval(() => {
        timeLeft--;
        timerText.innerText = `⏱️ ${timeLeft}`;

        // CHECK: Did time run out?
        if (timeLeft <= 0) {
            clearInterval(timerInterval); // Stop the clock
            handleAnswer("TIME_UP", "NO_ANSWER"); // Force a wrong answer
        }
    }, 1000);
}

function stopTimer() {
    clearInterval(timerInterval);
}

// FUNCTION C: Check Answer (Logic + POST Request)
async function handleAnswer(userAnswer, correctAnswer) {
    stopTimer(); // <--- STOP THE CLOCK immediately!
    // UI: Disable all buttons so user can't click twice
    const buttons = document.querySelectorAll(".option-btn");
    buttons.forEach(btn => btn.disabled = true);

    // OPTION 1: Local Check (Faster) -> We use this for UI speed
    const isCorrect = userAnswer.trim().toLowerCase() === correctAnswer.trim().toLowerCase();

    // OPTION 2: Server Check (More Secure) -> Good for resume to prove you can do POST
    // We can fire this off in the background or await it. 
    // For now, let's use the local check for instant visual feedback.

    if (isCorrect) {
        score++;
        // Visual Feedback (Green)
        buttons.forEach(btn => {
            if (btn.innerText.includes(userAnswer)) btn.style.borderColor = "#4ade80"; // Neon Green
        });
    } else {
        // Visual Feedback (Red)
        buttons.forEach(btn => {
            if (btn.innerText.includes(userAnswer)) btn.style.borderColor = "#ef4444"; // Red
            if (btn.innerText.includes(correctAnswer)) btn.style.borderColor = "#4ade80"; // Show correct one
        });
    }

    // Wait 1 second, then go to next question
    setTimeout(() => {
        currentQuestionIndex++;
        
        if (currentQuestionIndex < currentQuestions.length) {
            showQuestion();
        } else {
            endQuiz();
        }
    }, 1000);
}

// FUNCTION D: End Game
function endQuiz() {
    quizScreen.classList.add("hidden");
    resultScreen.classList.remove("hidden");

    finalScoreText.innerText = `${score} / ${currentQuestions.length}`;
    
    const percentage = (score / currentQuestions.length) * 100;
    scorePercentage.innerText = `(${percentage}%)`;
    
    if (percentage >= 80) {
        scorePercentage.style.color = "#4ade80"; // Green
    } else if (percentage >= 50) {
        scorePercentage.style.color = "#facc15"; // Yellow
    } else {
        scorePercentage.style.color = "#ef4444"; // Red
    }
}

// Add this listener at the top with others
document.getElementById("exit-btn").addEventListener("click", restartApp);

function restartApp() {
    stopTimer(); // <--- CRITICAL: Stop timer if they quit mid-game!

    resultScreen.classList.add("hidden");
    quizScreen.classList.add("hidden"); // Hide quiz screen too
    homeScreen.classList.remove("hidden");

    score = 0;
    currentQuestionIndex = 0;
}