package LAB4;

import LAB3.Fisherman;
import LAB3.FishermansParty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FishermenPartyTest {
    private FishermansParty fishermenPartyTest;
    @BeforeEach
    void setFishermenPartyTest(){
        fishermenPartyTest = new FishermansParty();
    }
    @ParameterizedTest
    @MethodSource("testFishermenProvider")
    void addFisherman(Fisherman fisherman) {
        fishermenPartyTest.addNewFisherman(fisherman);

        assertTrue(fishermenPartyTest.getFishermen().contains(fisherman));
    }
    @Test
    void competitionTest() {
        assertTrue(fishermenPartyTest.Competitions(0, new Date().getTime()));
    }
    private static Stream<Fisherman> testFishermenProvider() {
        return Stream.of(
                new Fisherman("Lesha"),
                new Fisherman("Sasha"),
                new Fisherman("Sergey"),
                new Fisherman("Artem")
        );
    }
}
