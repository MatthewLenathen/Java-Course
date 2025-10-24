import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // --- Normal trampoline (not NASA) tests ---

    @Test
    void normalTrampolineTooFew() {
        assertFalse(Main.happyLlamas(false, 10),
                "Should be unhappy with <24 trampolines (normal)");
    }

    @Test
    void normalTrampolineMinimumHappy() {
        assertTrue(Main.happyLlamas(false, 24),
                "Should be happy with exactly 24 trampolines (normal)");
    }

    @Test
    void normalTrampolineUpperLimitHappy() {
        assertTrue(Main.happyLlamas(false, 42),
                "Should still be happy with 42 trampolines (normal)");
    }

    @Test
    void normalTrampolineTooMany() {
        assertFalse(Main.happyLlamas(false, 43),
                "Should be unhappy with >42 trampolines (normal)");
    }

    // --- NASA fabric trampoline tests ---

    @Test
    void nasaTrampolineTooFew() {
        assertFalse(Main.happyLlamas(true, 10),
                "Should be unhappy with <24 trampolines (NASA)");
    }

    @Test
    void nasaTrampolineMinimumHappy() {
        assertTrue(Main.happyLlamas(true, 24),
                "Should be happy with exactly 24 trampolines (NASA)");
    }

    @Test
    void nasaTrampolineVeryManyStillHappy() {
        assertTrue(Main.happyLlamas(true, 100),
                "Should be happy with any number >=24 trampolines (NASA)");
    }

    // --- Edge/Boundary Tests ---

    @Test
    void normalTrampolineBoundaryJustBelow() {
        assertFalse(Main.happyLlamas(false, 23),
                "Boundary: just below 24 should be unhappy (normal)");
    }

    @Test
    void normalTrampolineBoundaryJustAbove() {
        assertTrue(Main.happyLlamas(false, 25),
                "Boundary: just above 24 should be happy (normal)");
    }

    @Test
    void normalTrampolineBoundaryAboveLimit() {
        assertFalse(Main.happyLlamas(false, 43),
                "Boundary: just above 42 should be unhappy (normal)");
    }
}
