package GameMaze_FIX;

public class penerjemah {

    public static String terjemahan(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            return "Kalimat kepanjangan";
        } else {
            if (in.length == 2) {
                if (in[0].matches("[udrlz]")) {
                    if (in[0].equals("u")) {
                        return "naik " + in[1] + " langkah";
                    } else if (in[0].equals("d")) {
                        return "turun " + in[1] + " langkah";
                    } else if (in[0].equals("r")) {
                        return "ke kanan " + in[1] + " langkah";
                    } else if (in[0].equals("l")) {
                        return "ke kiri " + in[1] + " langkah";
                    } else if (in[0].equals("z")) {
                        return "undo " + in[1] + " langkah";
                    } else {
                        return "Bukan naik, turun, kekanan, kekiri maupun undo";
                    }
                } else {
                    return "Kata tidak dikenal";
                }
            } else {
                return "Jumlah kata";
            }
        }
    }
}

