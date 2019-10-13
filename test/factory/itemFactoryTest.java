package factory;

import model.items.IEquipableItem;
import model.items.attack.heal.Staff;
import model.items.attack.magic.AnimaBook;
import model.items.attack.magic.DarkBook;
import model.items.attack.magic.LightBook;
import model.items.attack.normal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class itemFactoryTest {

    private ItemFactory factory;
    private Axe axe;
    private Bow bow;
    private Spear spear;
    private Sword sword;
    private AnimaBook anima;
    private DarkBook dark;
    private LightBook light;
    private Staff staff;

    @BeforeEach
    public void setUp(){

        this.factory = new ItemFactory();
        this.axe = new Axe("Axe", 10, 1, 1);
        this.bow = new Bow("Bow", 20, 1, 2);
        this.spear = new Spear("Spear", 30, 1, 1);
        this.sword = new Sword("Sword", 40, 1, 1);
        this.anima = new AnimaBook("Anima", 50, 1, 1);
        this.dark = new DarkBook("Dark", 60, 1, 1);
        this.light = new LightBook("Light", 70, 1, 1);
        this.staff = new Staff("Staff", 80, 1, 1);

    }

    @Test
    public void testUnitFactory(){

        IEquipableItem item = factory.createAxe(10, 1, 1);
        item.equalsTo(axe);

        IEquipableItem item1 = factory.createBow(20, 1, 2);
        item1.equalsTo(bow);

        IEquipableItem item2 = factory.createSpear(30, 1, 1);
        item2.equalsTo(spear);

        IEquipableItem item3 = factory.createSword(40, 1, 1);
        item3.equalsTo(sword);

        IEquipableItem item4 = factory.createAnima(50, 1, 1);
        item4.equalsTo(anima);

        IEquipableItem item5 = factory.createDark(60, 1, 1);
        item5.equalsTo(dark);

        IEquipableItem item6 = factory.createLight(70, 1, 1);
        item6.equalsTo(light);

        IEquipableItem item7 = factory.createStaff(80, 1, 1);
        item7.equalsTo(staff);

    }


}
