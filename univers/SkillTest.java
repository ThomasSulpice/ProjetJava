package univers;

import org.junit.*;
import static junit.framework.TestCase.*;

public class SkillTest {

    private Skill regardmenacantSkillUnderTest = new SkillSingle("Regard menaçant" , 0. , 1.0 , 1);

    @Test
    public void equals_skillRegardMenacant_returnsWhetherEqualsSkillDBRegardMenacant(){
        assertTrue(regardmenacantSkillUnderTest.equals(SkillDB.regardmenacant));
    }

    @Test
    public void toString_skillRegardMenacant_returnsDescription(){
        assertSame("Skill{" + "name='" + "Regard menaçant" + '\'' + ", multiplier=" + 0. + ", acc=" + 1.0 + ", levelReq=" + 1 + '}' ,
                regardmenacantSkillUnderTest.toString());
    }
}
