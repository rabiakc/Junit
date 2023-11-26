package day06_junit;

import org.junit.*;

public class C02_BeforeAfter {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("@BeforeClass Class dan önce bir kez çalışır.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before  Her test methodundan önce bir kez çalışır.");
    }

    @Test
    public void test01() {
        System.out.println("Test01 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 çalıştı");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After her test methodundan sonra bir kez çalışır.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass Classdan sonra bir kez çalışır");
    }
}
