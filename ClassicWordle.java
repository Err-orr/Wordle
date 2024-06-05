// Modules and imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ClassicWordle {
    // ANSI_RESET changes the text in a string to be white.
    public static String ANSI_RESET = "\u001B[0m";
    // ANSI_GREEN changes the text in a string to be green.
    public static String ANSI_GREEN = "\u001B[32m";
    // ANSI_YELLOW changes the text in a string to be yellow.
    public static String ANSI_YELLOW = "\u001B[33m";
    // wordsStartingWithA is a list that has almost all the words that start with the letter A.
    private static ArrayList<String> wordsStartingWithA = new ArrayList<String>();
    // wordsStartingWithB is a list that has almost all the words that start with the letter B.
    private static ArrayList<String> wordsStartingWithB = new ArrayList<String>();
    // wordsStartingWithC is a list that has almost all the words that start with the letter C.
    private static ArrayList<String> wordsStartingWithC = new ArrayList<String>();
    // wordsStartingWithD is a list that has almost all the words that start with the letter C.
    private static ArrayList<String> wordsStartingWithD = new ArrayList<String>();
    // wordsStartingWithE is a list that has almost all the words that start with the letter C.
    private static ArrayList<String> wordsStartingWithE = new ArrayList<String>();
    // Answer generates a random string from the wordsStartingWithA list.
    private static String answer = "N/A";
    private static int chosenLetter = 1;
    // Input is used to generate user input
    private static Scanner input = new Scanner(System.in);
    // wordAfterGuess is used with the ANSI reset, yellow, and green and is the last word the user guessed.
    private static StringBuilder wordAfterGuess = new StringBuilder();
    // The random number is used to choose what the word's letter starts with.
    private static Random number = new Random();
    // A cool default constructor for fun.
    public ClassicWordle() {
        answer = "";
        chosenLetter = 0;
        wordAfterGuess = new StringBuilder();
        number = new Random();
    }
    // This method returns our answer.
    public static String getWord() {
        return answer;
    }
    // This method adds all the words into their respective lists. This is intended to be used only once.
    public static void addWord() {
        if (wordsStartingWithA.isEmpty()) {
            wordsStartingWithA.addAll(Arrays.asList("ABIDE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACHOO", "ACIDS", "ACORN", "ACRES", "ACTED", "ACTOR", "ADAPT", "ADDED", "ADEPT", "ADMIN", "ADMIT", "ADOBE", "ADOPT", "ADORE", "ADULT", "AFOOT", "AFTER", "AGAIN", "AGENT", "AGGRO", "AGILE", "AGING", "AGONY", "AGREE", "AHEAD", "AHOLD", "AIDED", "AIMED", "AIMER", "AIRED", "AISLE", "ALARM", "ALBUM", "ALERT", "ALGAE", "ALIAS", "ALIBI", "ALIEN", "ALIGN", "ALIKE", "ALIVE", "ALLEY", "ALLOW", "ALLOY", "ALOHA", "ALONE", "ALONG", "ALOOF", "ALOUD", "ALPHA", "ALTAR", "ALTER", "ALUMS", "ALURE", "AMAZE", "AMBER", "AMEND", "AMENS", "AMINO", "AMMOS", "AMONG", "AMPED", "AMUSE", "ANGEL", "ANGER", "ANGLE", "ANGRY", "ANGST", "ANIME", "ANKLE", "ANNOY", "APART", "APHID", "APPLE", "APPLY", "APRON", "AQUAS", "ARBOR", "AREAS", "ARENA", "ARGUE", "ARGUS", "ARISE", "ARMED", "ARMOR", "AROMA", "AROSE", "ARRAY", "ARROW", "ARSON", "ARTSY", "ASHES", "ASIDE", "ASKED", "ASKEW", "ASSET", "ATLAS", "ATOMS", "ATONE", "ATTIC", "AUDIO", "AUDIT", "AUNTS", "AURAS", "AUTOS", "AVERT", "AVOID", "AWAIT", "AWAKE", "AWARD", "AWARE", "AXELS", "AXING", "AZURE"));
            wordsStartingWithB.addAll(Arrays.asList("BABES", "BACKS", "BACON", "BADGE", "BADDY", "BADLY", "BAGEL", "BAGGY", "BAILS", "BAITS", "BAKED", "BAKER", "BAKES", "BALDS", "BALDY", "BALLS", "BALLY", "BALMS", "BALMY", "BANDY", "BANGS", "BANJO", "BANKS", "BARBS", "BARFS", "BARFY", "BARKS", "BARKY", "BARNS", "BARNY", "BARON", "BARRY", "BASED", "BASER", "BASES", "BASIC", "BASIL", "BASIN", "BASIS", "BATCH", "BATED", "BATES", "BATHE", "BATHS", "BATON", "BEACH", "BEADS", "BEAKS", "BEAKY", "BEAMS", "BEANS", "BEARD", "BEARS", "BEAST", "BEATS", "BECAP", "BEECH", "BEEFS", "BEEFY", "BEEPS", "BEERS", "BEERY", "BEETS", "BEFIT", "BEFOG", "BEGAN", "BEGIN", "BEGUN", "BEIGE", "BEING", "BELCH", "BELLE", "BELLS", "BELLY", "BELOW", "BELTS", "BENCH", "BENDS", "BENDY", "BENTS", "BERET", "BERRY", "BESTS", "BETAS", "BIBLE", "BICEP", "BIDED", "BIDEN", "BIDER", "BIDES", "BIDET", "BIGOT", "BIKED", "BIKER", "BIKES", "BILLS", "BILLY", "BINDS", "BINGE", "BINGO", "BINGS", "BINGY", "BINKY", "BIOME", "BIPOD", "BIRCH", "BIRDS", "BIRDY", "BIRTH", "BISON", "BITES", "BITSY", "BLACK", "BLADE", "BLAHS", "BLAST", "BLAZE", "BLEAK", "BLEED", "BLEEP", "BLEND", "BLESS", "BLIMP", "BLIND", "BLING", "BLISS", "BLITZ", "BLOAT", "BLOBS", "BLOCK", "BLOGS", "BLOND", "BLOOD", "BLOOM", "BLOWN", "BLOWS", "BLOWY", "BLUED", "BLUER", "BLUES", "BLUEY", "BLUFF", "BLUNT", "BLURB", "BLURS", "BLURT", "BLUSH", "BOARD", "BOARS", "BOAST", "BOATS", "BOBAS", "BODES", "BOILS", "BOING", "BOINK", "BOLDS", "BOLTS", "BOMBS", "BONDS", "BONES", "BONEY", "BONGO", "BONGS", "BONKS", "BONNY", "BONUS", "BOOBS", "BOOBY", "BOOED", "BOOGY", "BOOKS", "BOOMS", "BOOMY", "BOOST", "BOOTH", "BOOTS", "BOOTY", "BOOZE", "BORED", "BOSSY", "BOWED", "BOWEL", "BOWIE", "BOWLS", "BOXED", "BOXER", "BOXES", "BRAGS", "BRAID", "BRAKE", "BRAND", "BRASH", "BRASS", "BRAVE", "BRAVO", "BRAWL", "BRAWN", "BREAD", "BREAK", "BREED", "BREWS", "BRICK", "BRIDE", "BRIEF", "BRING", "BRINK", "BRISK", "BRISS", "BRITS", "BROAD", "BROCK", "BROIL", "BROKE", "BROOD", "BROOK", "BROOM", "BROWN"));
            wordsStartingWithC.addAll(Arrays.asList("CABIN", "CABLE", "CACAO", "CACHE", "CACTI", "CADET", "CAFES", "CAGED", "CAKED", "CAKES", "CALFS", "CALLS", "CALMS", "CAMEL", "CAMEO", "CAMPS", "CAMPY", "CANAL", "CANDY", "CANED", "CANES", "CANOE", "CANON", "CAPED", "CAPER", "CAPES", "CARAT", "CARBS", "CARDI", "CARDS", "CARLS", "CAROL", "CARRY", "CARTS", "CASED", "CASES", "CATCH", "CATER", "CAULK", "CAUSE", "CAVED", "CAVER", "CAVES", "CEASE", "CEDAR", "CELEB", "CELLS", "CENTS", "CERCI", "CERES", "CHADS", "CHAIN", "CHAIR", "CHALK", "CHAMP", "CHANT", "CHAOS", "CHAPS", "CHARM", "CHARS", "CHART", "CHASE", "CHASM", "CHATS", "CHEAP", "CHEAT", "CHECK", "CHEEK", "CHEEP", "CHEER", "CHEFS", "CHESS", "CHEST", "CHEVY", "CHEWS", "CHEWY", "CHICK", "CHICS", "CHIEF", "CHILD", "CHILE", "CHILI", "CHILL", "CHIME", "CHIMP", "CHINA", "CHINS", "CHIPS", "CHIRP", "CHOIR", "CHOKE", "CHOMP", "CHOPS", "CHORD", "CHORE", "CHOSE", "CHOWS", "CHUCK", "CHUGS", "CHUMP", "CHUMS", "CHUNK", "CHUTE", "CHYME", "CIDER", "CIGAR", "CIGGY", "CINCH", "CITED", "CITER", "CITES", "CIVIL", "CIVVY", "CLACK", "CLAIM", "CLAMP", "CLAMS", "CLANG", "CLANK", "CLANS", "CLAPS", "CLASH", "CLASP", "CLASS", "CLAWS", "CLAYS", "CLEAN", "CLEAR", "CLEAT", "CLEFS", "CLEFT", "CLEGS", "CLERK", "CLICK", "CLIFF", "CLIMB", "CLING", "CLIPS", "CLOAK", "CLOCK", "CLODS", "CLOGS", "CLONE", "CLOPS", "CLOSE", "CLOTH", "CLOTS", "CLOUD", "CLOUT", "CLOVE", "CLOWN", "CLOYS", "CLUBS", "CLUCK", "CLUED", "CLUES", "CLUMP", "CLUNG", "CLUNK", "COACH", "COAST", "COATS", "COBRA", "COCKY", "COCOA", "CODEC", "CODED", "CODER", "CODES", "COILS", "COINS", "COLAS", "COLDS", "COLON", "COLOR", "COLTS", "COMAS", "COMBO", "COMBS", "COMES", "COMET", "COMFY", "COMIC", "COMMA", "CONCH", "CONED", "CONES", "CONEY", "CONGA", "CONVO", "COOED", "COOKS", "COPED", "COPER", "COPES", "CORAL", "CORDS", "CORED", "CORES", "CORKS", "CORNS", "CORNY", "CORPS", "COSTS", "COUCH", "COUGH", "COULD", "COUNT", "COUPE", "COUPS", "COURT", "COVED", "COVER", "COVES", "COVET", "COWED", "CRABS", "CRACK", "CRAFT", "CRAMP", "CRAMS", "CRANE", "CRANK", "CRAPY", "CRASH", "CRATE", "CRAVE", "CRAWL", "CRAZE", "CRAZY", "CREAK", "CREAM", "CREED", "CREEK", "CREEP", "CREME", "CREPE", "CREPT", "CREST", "CREWS", "CRIED"));
            wordsStartingWithD.addAll(Arrays.asList("DADDY", "DAFFY", "DAILY", "DAIRY", "DAISY", "DALES", "DAAMNS", "DANCE", "DARED", "DARER", "DARES", "DARKS", "DARNS", "DARTS", "DASHY", "DATED", "DATER", "DATES", "DAUNT", "DAWGS", "DAWNS", "DAZED", "DAZES", "DEADS", "DEALS", "DEALT", "DEANS", "DEARS", "DEARY", "DEATH", "DEBIT", "DEBTS", "DEBUG", "DEBUT", "DECAF", "DECAL", "DECAY", "DECKS", "DECOR", "DECOY", "DEEDS", "DEEMS", "DEEPS", "DEERS", "DEFER", "DEFOG", "DELAY", "DEMON", "DEMOS", "DENIM", "DENSE", "DEOXY", "DEPOT", "DEPTH", "DESKS", "DETER", "DEUCE", "DEVIL", "DIALS", "DIARY", "DICED", "DICER", "DICES", "DICEY", "DIGIT", "DIKED", "DIKER", "DIKES", "DIMER", "DIMES", "DIMLY", "DINED", "DINER", "DINES", "DINGE", "DINGO", "DINGS", "DINGY", "DINKS", "DINKY", "DINOS", "DIPPY", "DIRKS", "DIRTS", "DIRTY", "DISCO", "DISCS", "DISHY", "DISKS", "DITCH", "DITTO", "DIVED", "DIVER", "DIVEY", "DIVOT", "DIZZY", "DJINN", "DJINS", "DOCKS", "DODGE", "DODGY", "DOGES", "DOGEY", "DOGGO", "DOGGY", "DOING", "DOJOS", "DOLLS", "DOLLY", "DOMED", "DOMES", "DONUT", "DOORS", "DOOZY", "DORKY", "DORMS", "DOUBT", "DOUGH", "DOUSE", "DOVEN", "DOVES", "DOWNS", "DOWNY", "DOZED", "DOZEN", "DOZER", "DOZES", "DRAFT", "DRAIN", "DRAKE", "DRAMA", "DRAWN", "DRAWS", "DREAD", "DREAM", "DRESS", "DRIED", "DRIER", "DRIES", "DRIFT", "DRINK", "DRIPS", "DRIVE", "DROID", "DRONE", "DROPS", "DROVE", "DROWN", "DRUID", "DRUMS", "DRUNK", "DRYER", "DUALS", "DUCKS", "DUCKY", "DUDES", "DUELS", "DUETS", "DUFUS", "DUKED", "DUKES", "DUMBO", "DUMBS", "DUMPY", "DUNES", "DUPED", "DUPES", "DUSKS", "DUSKY", "DUSTY", "DUTCH", "DWARF", "DWEEB", "DYING", "DYKES", "DYNOS"));
            wordsStartingWithE.addAll(Arrays.asList("EAGER", "EAGLE", "EARLY", "EARNS", "EARTH", "EASED", "EASES", "EATEN", "EATER", "EATIN", "EBANK", "EBOLA", "EBONY", "EBOOK", "ECARD", "ECASH", "ECHOS", "EDGED", "EDGES", "EDITS", "EERIE", "EGADS", "EGGED", "EGGER", "EIGHT", "EJECT", "ELBOW", "ELDER", "ELECT", "EMBED", "EMBER", "EMMET", "EMOJI", "EMOTE", "EMPTY", "ENDED", "ENDER", "ENEMY", "ENJOY", "ENTER", "ENTRY", "ENVIE", "EPICS", "EPOXY", "EQUAL", "EQUIP", "ERASE", "ERODE", "ERROR", "ERUPT", "ESSAY", "ETHOS", "EUROS", "EVADE", "EVENS", "EVENT", "EVERT", "EVERY", "EVICT", "EVOKE", "EXACT", "EXAMS", "EXCEL", "EXIST", "EXITS", "EXTRA", "EYING"));
        }
    }
    // This method generates a new answer.
    public static void setWord() {
        chosenLetter = number.nextInt(5);
        if (chosenLetter == 0) {
            answer = wordsStartingWithA.get(new Random().nextInt(wordsStartingWithA.size())).toUpperCase();
        } else if (chosenLetter == 1) {
            answer = wordsStartingWithB.get(new Random().nextInt(wordsStartingWithB.size())).toUpperCase();
        } else if (chosenLetter == 2) {
            answer = wordsStartingWithC.get(new Random().nextInt(wordsStartingWithC.size())).toUpperCase();
        } else if (chosenLetter == 3){
            answer = wordsStartingWithD.get(new Random().nextInt(wordsStartingWithD.size())).toUpperCase();
        } else {
            answer = wordsStartingWithE.get(new Random().nextInt(wordsStartingWithE.size())).toUpperCase();
        }
    }
    public static void userGuess() {
        // This for loop gives the user a total of 6 guesses.
        for (int j = 0; j < 6; j++) {
            System.out.println("Guesses left: " + (6 - j));
            System.out.print("Guess a word: ");
            // The guess variable is always set to uppercase, so we don't have any issues with finding characters.
            String guess = input.nextLine().toUpperCase();
            // Here's a nested for loop that checks through every character the user guessed to see if it matches with the answer.
            for (int i = 0; i < guess.length(); i++) {
                char letterInGuess = guess.charAt(i);
                // If the guessed letter's position matches with the position in the answer, then the letter will be green.
                if (answer.charAt(i) == letterInGuess) {
                    wordAfterGuess.append(ANSI_GREEN + letterInGuess + ANSI_RESET);
                    // If the guessed letter is in the word, then the letter will be yellow.
                } else if (answer.contains(Character.toString(letterInGuess))) {
                    wordAfterGuess.append(ANSI_YELLOW + letterInGuess + ANSI_RESET);
                    // Their guess will have no recoloring of text.
                } else {
                    wordAfterGuess.append(letterInGuess);
                }
            }
            // Their guess is shown and a new memory location is created for another guess.
            System.out.println(wordAfterGuess);
            wordAfterGuess = new StringBuilder();
            if (guess.equals(answer)) {
                // Victory message for a correct guess.
                System.out.println("Congratulations, you guessed correctly!");
                // j is set to 7, so we can exit the loop.
                j = 7;
            } else if (j == 5) {
                // Defeat message after all 6 incorrect guesses.
                System.out.println("Sorry, you did not guess correctly.");
                System.out.println("The answer was " + answer);
            }
        }
    }
}