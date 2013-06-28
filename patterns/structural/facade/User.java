package structural.facade;

/* Complex parts */

class CPU {
    public void freeze() { System.out.println("freeze"); }
    public void jump(long position) { System.out.println("jump"); }
    public void execute() { System.out.println("execute"); }
}
 
class Memory {
    public void load(long position, byte[] data) { System.out.println("memory load"); }
}
 
class HardDrive {
    public byte[] read(long lba, int size) { System.out.println("harddrive read"); return null; }
}
 
/* Facade */
 
class Computer {
    private static final long BOOT_ADDRESS = 0;
	private static final long BOOT_SECTOR = 0;
	private static final int SECTOR_SIZE = 0;
	private CPU processor;
    private Memory ram;
    private HardDrive hd;
 
    public Computer() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }
 
    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}
 
/* Client */
 
class User {
    public static void main(String[] args) {
        Computer facade = new Computer();
        facade.start();
    }
}