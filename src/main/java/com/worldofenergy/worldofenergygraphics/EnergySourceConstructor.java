package com.worldofenergy.worldofenergygraphics;

public interface EnergySourceConstructor {
    String[] types = {"Windmill", "Solar Panel", "Hydro Powerplant", "Geo Powerplant"};

    static EnergySource constructWind() {
        return new WindMill();
    }

    static EnergySource constructHydro() {
        return new HydroPowerplant();
    }

    static EnergySource constructGeo() {
        return new GeothermalPowerplant();
    }

    static EnergySource constructSolar() {
        return new SolarPanel();
    }

    boolean ValidateFunds(EnergySource e);

    static void printWindmill() {
        System.out.println("                                      __");
        System.out.println("                ,-_                  (`  ).");
        System.out.println("                |-_'-,              (     ).");
        System.out.println("                |-_'-'           _(        '`.");
        System.out.println("       _        |-_'/        .=(`(      .     )");
        System.out.println("      /;-,_     |-_'        (     (.__.:-`-_.'");
        System.out.println("     /-.-;,-,___|'          `(       ) )");
        System.out.println("    /;-;-;-;_;_/|\\_ _ _ _ _   ` __.:'   )");
        System.out.println("       x_( __`|_P_|`-;-;-;,|        `--'");
        System.out.println("       |\\ \\    _||   `-;-;-'");
        System.out.println("       | \\`   -_|.      '-'");
        System.out.println("       | /   /-_| `");
        System.out.println("       |/   ,'-_|  \\");
        System.out.println("       /____|'-_|___\\");
        System.out.println("     _..,____]__|_\\-_'|_[___,.._        ");


    }

    static void printWaterPump() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⠋⠉⠉⢷⠒⠒⠶⣄⡀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠹⣄⣀⣠⡾⠴⠤⣄⠀⠻⡄⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⣤⠶⠷⠿⠿⠷⢦⠀⠘⡆⠀⣿⠀⠀⠀⠀");
        System.out.println("⠀⠀⢀⣀⣀⣀⣙⣟⠛⠛⠛⢻⠋⠀⣠⡇⠀⣿⠀⠀⠀⠀");
        System.out.println("⠀⡼⠋⠉⠉⠉⠉⣿⠀⠀⠀⢸⣖⡋⠁⡇⠀⣿⠀⠀⠀⠀");
        System.out.println("⠘⣇⣠⡞⠛⠛⠛⣷⠀⠀⠀⢸⠈⠙⠺⣇⠀⢻⣄⣀⣀⡀");
        System.out.println("⠀⣰⣅⠀⠀⠀⠀⣿⠀⠀⠀⢸⠀⠀⠀⠙⢦⣀⡀⠀⢀⣽");
        System.out.println("⣼⠁⠘⣆⠀⠀⠀⣿⠀⠀⠀⢸⠀⠀⠀⠀⠀⠈⠉⠉⠉⠀");
        System.out.println("⢿⣀⣠⡟⠀⠀⠀⣿⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠈⠁⠀⠀⠀⠀⣿⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⣀⣿⣀⣀⣀⣸⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⢀⣸⣭⣭⣭⣭⣭⣭⣭⣽⡀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⢸⣁⣀⣀⣀⣀⣀⣀⣀⣀⣹⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀");
    }
    static void printSolarPanel(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡀⠀⠀⠀⠀⢠⠄⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣄⣀⣀⣠⠏⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠋⠀⠀⠙⢦⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠒⠒⠚⡇⠀⠀⠀⠀⢸⠓⠒⠒⠂⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣦⣄⣠⢴⠋⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠁⠀⠀⠈⢣⡀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣈⡥⠤⢄⡀⠀⠀⠃⠀⠀⠀⠀⠀⠀");
        System.out.println("⢀⣀⣀⣀⣀⣤⠤⠤⠤⠶⠒⠒⠒⠚⠻⣍⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⢙⣄⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠈⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣷⣄⣤⠤⠴⠶⠒⠚⠋⠉⠉⠁⠱⣄⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠙⢦⣀⣀⣤⠤⠤⠶⠒⠒⠚⠉⠉⠉⠀⠈⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⢀⣀⣠⠤⠖⠒⠋⠳⣄⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠙⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠬⠷⣞⠋⠉⠀⠀⠀⠀⠀⠀⠀⠈⣳⣄");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠳⣄⠀⠀⣀⣀⡤⠴⠒⠋⠉⠁⠀⠀⠀⠈⠳⣄⠀⠀⢀⣀⡤⠔⠚⠉⠉⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣍⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡤⠼⠓⠋⠉⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⣀⣤⠴⠒⢻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠒⠚⠉⠁⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠒⠒⠚⠒⠒⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }
    static void printGeoThermal(){
        System.out.println("                             __  . .* ,");
        System.out.println("                           ~#@#%(\" .,$ @");
        System.out.println("                            .\"^ ';\"");
        System.out.println("                          ..");
        System.out.println("                         ;. :                                   . .");
        System.out.println("                         ;==:                     ,,   ,.@#(&*.;'");
        System.out.println("                         ;. :                   .;#$% & ^^&");
        System.out.println("                         ;==:                   &  ......");
        System.out.println("                         ;. :                   ,,;      :");
        System.out.println("                         ;==:  ._______.       ;  ;      :");
        System.out.println("                         ;. :  ;    ###:__.    ;  ;      :");
        System.out.println("   _____________________.'  `._;       :  :__.' .'        `.__________________");
    }
}
