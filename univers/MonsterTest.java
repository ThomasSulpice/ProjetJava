package univers;

import org.junit.*;
import static junit.framework.TestCase.*;

public class MonsterTest {
    private Monster lvl1MonsterUnderTest = new Monster("testMonster" , new Skill[] {SkillDB.regardmenacant} , 1);

    @Before
    public void resetMonster(){
        lvl1MonsterUnderTest = new Monster("testMonster" , new Skill[] {SkillDB.regardmenacant} , 1);
    }

    @Test
    public void killExp_lvl1Monster_returnsExpOnKill(){
        assertEquals((int) (1 + Math.round(50.0 / 7)) , lvl1MonsterUnderTest.killExp());
    }

    @Test
    public void getSkillUsed_lvl1Monster_returnsSkillUsed(){
        assertSame(SkillDB.regardmenacant , lvl1MonsterUnderTest.getSkillUsed());
    }

    @Test
    public void setSkillUsed_lvl1Monster_setsSkillUsedToBouledefeu(){
        lvl1MonsterUnderTest.setSkillUsed(SkillDB.bouledefeu);
        assertSame(SkillDB.bouledefeu , lvl1MonsterUnderTest.getSkillUsed());
    }
}
