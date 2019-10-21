package factory;

import factory.item.*;
import model.items.IEquipableItem;
import model.items.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class itemFactoryTest {

    private Axe axe;
    private Bow bow;
    private Spear spear;
    private Sword sword;
    private AnimaBook anima;
    private DarkBook dark;
    private LightBook light;
    private Staff staff;
    private AxeFactory axeFactory;
    private BowFactory bowFactory;
    private SpearFactory spearFactory;
    private SwordFactory swordFactory;
    private AnimaFactory animaFactory;
    private DarkFactory darkFactory;
    private LightFactory lightFactory;
    private StaffFactory staffFactory;

    @BeforeEach
    public void setUp(){

        this.axe = new Axe("Axe", 10, 1, 1);
        this.bow = new Bow("Bow", 20, 1, 2);
        this.spear = new Spear("Spear", 30, 1, 1);
        this.sword = new Sword("Sword", 40, 1, 1);
        this.anima = new AnimaBook("Anima", 50, 1, 1);
        this.dark = new DarkBook("Dark", 60, 1, 1);
        this.light = new LightBook("Light", 70, 1, 1);
        this.staff = new Staff("Staff", 80, 1, 1);
        this.axeFactory = new AxeFactory();
        this.bowFactory = new BowFactory();
        this.spearFactory = new SpearFactory();
        this.swordFactory = new SwordFactory();
        this.animaFactory = new AnimaFactory();
        this.darkFactory = new DarkFactory();
        this.lightFactory = new LightFactory();
        this.staffFactory = new StaffFactory();
    }

    @Test
    public void testUnitFactory(){


        IEquipableItem item = axeFactory.create(10, 1, 1);
        assertTrue(item.equalsTo(axe));
        IEquipableItem itemDefault = axeFactory.createDefault();
        assertEquals(itemDefault.getPower(), 40);
        assertEquals(itemDefault.getMinRange(), 1);
        assertEquals(itemDefault.getMaxRange(), 2);

        IEquipableItem item1 = bowFactory.create(20, 1, 2);
        assertTrue(item1.equalsTo(bow));
        IEquipableItem itemDefault1 = bowFactory.createDefault();
        assertEquals(itemDefault1.getPower(), 25);
        assertEquals(itemDefault1.getMinRange(), 2);
        assertEquals(itemDefault1.getMaxRange(), 3);


        IEquipableItem item2 = spearFactory.create(30, 1, 1);
        assertTrue(item2.equalsTo(spear));
        IEquipableItem itemDefault2 = spearFactory.createDefault();
        assertEquals(itemDefault2.getPower(), 30);
        assertEquals(itemDefault2.getMinRange(), 1);
        assertEquals(itemDefault2.getMaxRange(), 2);

        IEquipableItem item3 = swordFactory.create(40, 1, 1);
        assertTrue(item3.equalsTo(sword));
        IEquipableItem itemDefault3 = swordFactory.createDefault();
        assertEquals(itemDefault3.getPower(), 50);
        assertEquals(itemDefault3.getMinRange(), 1);
        assertEquals(itemDefault3.getMaxRange(), 2);

        IEquipableItem item4 = animaFactory.create(50, 1, 1);
        assertTrue(item4.equalsTo(anima));
        IEquipableItem itemDefault4 = animaFactory.createDefault();
        assertEquals(itemDefault4.getPower(), 40);
        assertEquals(itemDefault4.getMinRange(), 1);
        assertEquals(itemDefault4.getMaxRange(), 3);

        IEquipableItem item5 = darkFactory.create(60, 1, 1);
        assertTrue(item5.equalsTo(dark));
        IEquipableItem itemDefault5 = darkFactory.createDefault();
        assertEquals(itemDefault5.getPower(), 50);
        assertEquals(itemDefault5.getMinRange(), 1);
        assertEquals(itemDefault5.getMaxRange(), 3);

        IEquipableItem item6 = lightFactory.create(70, 1, 1);
        assertTrue(item6.equalsTo(light));
        IEquipableItem itemDefault6 = lightFactory.createDefault();
        assertEquals(itemDefault6.getPower(), 50);
        assertEquals(itemDefault6.getMinRange(), 1);
        assertEquals(itemDefault6.getMaxRange(), 3);

        IEquipableItem item7 = staffFactory.create(80, 1, 1);
        assertTrue(item7.equalsTo(staff));
        IEquipableItem itemDefault7 = staffFactory.createDefault();
        assertEquals(itemDefault7.getPower(), -40);
        assertEquals(itemDefault7.getMinRange(), 1);
        assertEquals(itemDefault7.getMaxRange(), 3);
    }


}
