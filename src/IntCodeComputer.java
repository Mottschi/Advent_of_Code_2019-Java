import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IntCodeComputer {
     HashMap<Long, Long> memory = new HashMap<Long, Long>();

    long pointer = 0;
    long relativeBase = 0;

    public IntCodeComputer(ArrayList<Long> data) {
        for (int i = 0; i < data.size(); i++) {
            this.memory.put(Long.valueOf(i), data.get(i));
        }
    }

    public long runProgram() {
        long opCode = this.memory.get(this.pointer);

        long a = 0;
        long b = 0;
        long storeAt;

        long parameters;
        long value = 0;

        long opCounter = 0;

        while (opCode != 99) {
            parameters = opCode / 100;
            opCode = opCode % 100;
            opCounter ++;

//            System.out.println("\nNext array parts to work with: ");
//            System.out.print("["+memory.getOrDefault(this.pointer, Long.valueOf(0)) +","+ memory.getOrDefault(this.pointer+1, Long.valueOf(0))+",");
//            System.out.println(memory.getOrDefault(this.pointer+2, Long.valueOf(0))+","+memory.getOrDefault(this.pointer+3, Long.valueOf(0))+"]");
//            System.out.println("Operation #" + opCounter + ": Pointer at: " + this.pointer+", Relative Base: "+relativeBase);


            value = this.memory.getOrDefault(this.pointer + 1, Long.valueOf(0));
            if (parameters % 10 == 0) {
//                System.out.println("Position mode for a");
                a = this.memory.getOrDefault(value, Long.valueOf(0));
            } else if (parameters % 10 == 1) {
//                System.out.println("Immediate mode for a");
                a = value;
            } else if (parameters % 10 == 2) {
//                System.out.println("Relative mode for a");
                a = this.memory.getOrDefault(value + this.relativeBase, Long.valueOf(0));
            }

            parameters /= 10;
            value = this.memory.getOrDefault(this.pointer + 2, Long.valueOf(0));
            if (parameters % 10 == 0) {
//                System.out.println("Position mode for b");
                b = this.memory.getOrDefault(value, Long.valueOf(0));
            } else if (parameters % 10 == 1) {
//                System.out.println("Immediate mode for b");
                b = value;
            } else if (parameters % 10 == 2) {
//                System.out.println("Relative mode for b");
                b = this.memory.getOrDefault( value + this.relativeBase, Long.valueOf(0));
            }

            parameters /= 10;
            storeAt = this.memory.getOrDefault(this.pointer + 3, Long.valueOf(0));
            if (parameters % 10 == 2) {
                storeAt += this.relativeBase;
            }

            switch ((int) opCode) {
                case 1: // Adding
                    add(a, b, storeAt);
                    this.pointer += 4;
                    break;
                case 2: // Multiplying
                    multiply(a, b, storeAt);
                    this.pointer += 4;
                    break;
                case 3: // Input
                    parameters = this.memory.getOrDefault(this.pointer, Long.valueOf(0)) / 100;

                    storeAt = this.memory.getOrDefault(this.pointer + 1, Long.valueOf(0));
                    if (parameters % 10 == 2) {
                        storeAt += this.relativeBase;
                    }
                    input(storeAt);
                    this.pointer += 2;
                    break;
                case 4: // Output
                    output(a);
                    this.pointer += 2;
                    break;
                case 5:
                    // Jump if true
//                    System.out.println("Jumping if True");
                    jumpIfTrue(a, b);
                    break;
                case 6:
                    // Jump if false
//                    System.out.println("Jumping if False");

                    jumpIfFalse(a, b);
                    break;
                case 7:
                    // Less Than
                    lessThan(a, b, storeAt);
                    this.pointer += 4;
                    break;
                case 8:
                    // Equals
                    equal(a, b, storeAt);
                    this.pointer += 4;
                    break;
                case 9:
                    adjustRelativeBase(a);
                    this.pointer += 2;
                    break;
                case 99:
                    break;
                default:
                    return -1;
            }

            opCode = this.memory.getOrDefault(this.pointer, Long.valueOf(0));
        }
        return this.memory.get(Long.valueOf(0));
    }

    private void add(long a, long b, long at) {
//        System.out.println("Adding " + a + " and " + b + " and storing " + (a+b) + " at " + at);
        this.memory.put(at, a + b);
    }

    private void multiply(long a, long b, long at) {
//        System.out.println("Multiplying " + a + " and " + b + " and storing "+ (a*b) + " at " + at);
        this.memory.put(at, a * b);
    }

    private void input(long at) {
        long inp;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input needed: ");
        inp = Long.parseLong(scanner.nextLine());

        this.memory.put(at, inp);
//        System.out.println("Saved "+inp+" at " + at);
    }

    private void output(long a) {
        System.out.println("Output: " + a);
    }

    private void lessThan(long a, long b, long at) {
        if (a < b) {
            this.memory.put(at, (long) 1);
        } else {
            this.memory.put(at, (long) 0);
        }
    }

    private void equal(long a, long b, long at) {
//        System.out.println("Checking whether "+a+" and "+b+" are equal. Saving at " + at);
        if (a == b) {
            this.memory.put(at, (long) 1);
        } else {
            this.memory.put(at, (long) 0);
        }
//        System.out.println(this.memory.get(at));
    }

    private void jumpIfTrue(long a, long b) {
        if (a != 0) {
            this.pointer = (int) b;
        } else {
            this.pointer += 3;
        }
    }

    private void jumpIfFalse(long a, long b) {
        if (a == 0) {
            this.pointer = (int) b;
        } else {
            this.pointer += 3;
        }
    }

    private void adjustRelativeBase(long a) {
        this.relativeBase += a;
    }


}
