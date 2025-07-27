package com.electrica.gameOfLife.ui;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.stereotype.Component;

import com.electrica.gameOfLife.contracts.Evolutionable;

@Component
public class GameUI implements Runnable  {

    private final AttributedString spriteAlive = new AttributedString(
            "█",
            AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));

    private final AttributedString spriteDeath = new AttributedString(
            "█",
            AttributedStyle.DEFAULT.foreground(AttributedStyle.WHITE));
    private final AttributedString spriteNewBorn = new AttributedString(
            "█",
            AttributedStyle.DEFAULT.foreground(AttributedStyle.MAGENTA));


    // @Value("${spring.aplication.speed: 1000}")
    private int refreshRate = 1000;

    private Evolutionable ecosystem;

    public GameUI(Evolutionable ecosystem, int refreshRate) {
        this.ecosystem = ecosystem;
        this.refreshRate = refreshRate;
    }

 @Override
public void run() {
    try {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        while (true) {
            clearScreen(terminal);

            for (int y = 0; y < ecosystem.height(); y++) {
                for (int x = 0; x < ecosystem.width(); x++) {
                    switch (ecosystem.cellAt(x, y).getCellState().colorCode()) {
                        case AttributedStyle.GREEN:
                            terminal.writer().print(spriteAlive.toAnsi(terminal));
                            break;
                        case AttributedStyle.WHITE:
                            terminal.writer().print(spriteDeath.toAnsi(terminal));
                            break;
                        case AttributedStyle.MAGENTA:
                            terminal.writer().print(spriteNewBorn.toAnsi(terminal));
                            break;
                        default:
                            terminal.writer().print(" ");
                    }
                }
                terminal.writer().println();
            }

            terminal.flush(); // ← flush después de toda la grilla
            Thread.sleep(refreshRate);
            ecosystem.evolve();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    protected void clearScreen(Terminal terminal) throws Exception {
        terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
        terminal.flush();
    }

}
