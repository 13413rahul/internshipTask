class CommandLine {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("please enter something in command line");
            return;
        }

        System.out.println("this is value that is enter in commandline : ");
        for(int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }
}