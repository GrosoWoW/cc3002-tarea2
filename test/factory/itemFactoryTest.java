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
        item.equalsTo(axe);

        IEquipableItem item1 = bowFactory.create(20, 1, 2);
        item1.equalsTo(bow);

        IEquipableItem item2 = spearFactory.create(30, 1, 1);
        item2.equalsTo(spear);

        IEquipableItem item3 = swordFactory.create(40, 1, 1);
        item3.equalsTo(sword);

        IEquipableItem item4 = animaFactory.create(50, 1, 1);
        item4.equalsTo(anima);

        IEquipableItem item5 = darkFactory.create(60, 1, 1);
        item5.equalsTo(dark);

        IEquipableItem item6 = lightFactory.create(70, 1, 1);
        item6.equalsTo(light);

        IEquipableItem item7 = staffFactory.create(80, 1, 1);
        item7.equalsTo(staff);

    }


}
