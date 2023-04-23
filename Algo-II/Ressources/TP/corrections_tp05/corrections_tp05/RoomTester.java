public class RoomTester
{
    public static void showRoom(Room room)
    {
        System.out.println(room.name());
        System.out.println(room);
    }

    public static void main(String[] args)
    {
        showRoom(new ComputerRoom());
        showRoom(new ComputerRoom(21, 666, "white", 9000, "Windows NT"));
        showRoom(new LectureRoom());
    }
}
