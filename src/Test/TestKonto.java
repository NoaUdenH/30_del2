package Test;

import Spil.Konto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TestKonto {

    Konto konto = new Konto();

    @Test
    public void KontoSkalIkkeGåIminus (){
        assertEquals(0, konto.minBalance());
    }
}
