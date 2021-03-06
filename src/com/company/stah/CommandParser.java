package com.company.stah;
import com.company.stah.model.Date;
import com.company.stah.model.Event;
import org.apache.commons.cli.*;


public class CommandParser {

    private boolean isFind = false;
    private boolean isSet = false;
    private int max = 0;
    private String filePath = null;

    public boolean isFind() {
        return isFind;
    }

    public boolean isSet() {
        return isSet;
    }

    public int getMax() {
        return max;
    }

    public Event getEvent() {
        return event;
    }

    public Date getDate() {
        return date;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    private Event event = null;
    private Date date = null;
    private Date start = null;
    private Date end = null;

    public void parser(String[] args) {

        Options opts = new Options();
        opts.addOption("f", "find", false, "Find Start-End Event mode.");
        opts.addOption("s", "set_schedule", false, "Set Schedule ");
        opts.addOption("d", "debug", false, "out put log mode");

        Option maxOpt = Option.builder("max")
                .required(false)
                .hasArg(true)
                .desc("Event max count")
                .argName("max")
                .build();

        Option dateOpt   = Option.builder("date")
                .required(false)
                .hasArg(true)
                .desc("Scheduled date")
                .argName("date")
                .build();
        Option eventOpt = Option.builder("event")
                .required(false)
                .hasArg(true)
                .desc("Scheduled event")
                .argName("event")
                .build();
        Option startOpt = Option.builder("start")
                .required(false)
                .hasArg(true)
                .desc("start date")
                .argName("start date")
                .build();

        Option endOpt = Option.builder("end")
                .required(false)
                .hasArg(true)
                .desc("end date")
                .argName("end date")
                .build();
        Option fileOpt = Option.builder("filepath")
                .required(false)
                .hasArg(true)
                .desc("output file path")
                .argName("file path")
                .build();

        opts.addOption(maxOpt);
        opts.addOption(dateOpt);
        opts.addOption(eventOpt);
        opts.addOption(startOpt);
        opts.addOption(endOpt);
        opts.addOption(fileOpt);

        DefaultParser parser = new DefaultParser();
        CommandLine cl;

        boolean debugFlag = false;

        try {
            cl = parser.parse(opts, args);

            if( cl.hasOption("s") && cl.hasOption("f") ) {
                System.out.println("-s and -f both setting error");
                return;
            }

            if ( cl.hasOption("s") ) {
                isSet = true;
                if ( cl.hasOption("event")) event = new Event(cl.getOptionValue("event"));
                if ( cl.hasOption("date")) date = new Date(cl.getOptionValue("date"));

            }
            if ( cl.hasOption("f") ) {
                isFind = true;
                if ( cl.hasOption("start")) start = new Date(cl.getOptionValue("start"));
                if ( cl.hasOption("end")) end = new Date(cl.getOptionValue("end"));
            }
            if ( cl.hasOption("d") ) debugFlag = true;
            if ( cl.hasOption("max")) max = Integer.parseInt(cl.getOptionValue("max"));
            if ( cl.hasOption("filepath")) filePath = cl.getOptionValue("filepath");


        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("My Java Application", opts);
            System.exit(1);
        }

        System.out.println("Starting application...");
        System.out.println("SetEvent mode : " + isSet);
        System.out.println("Find     mode : " + isFind);
        System.out.println("Debug    mode : " + debugFlag);
        System.out.println("max     count : " + max);
        if(event != null) System.out.println("event         : " + event.getEvent());
        if(date != null)  System.out.println("date          : " + date.getDate());
        if(start != null) System.out.println("start         : " + start.getDate());
        if(end != null)   System.out.println("end           : " + end.getDate());
        System.out.println("file path     : " + filePath);
        String line_sep = System.getProperty("line.separator");
        System.out.println("command arg parse end..." + line_sep);

    }





}
