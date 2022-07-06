package Model;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintTextModel extends TextField
{
    Font gainFont = new Font("Tahoma", Font.PLAIN, 15);
    Font lostFont = new Font("Tahoma", Font.ITALIC, 15);

    public HintTextModel(final String hint)
    {
        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (getText().equals(hint))
                {
                    setText("");
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }

                else
                {
                    setText(getText());
                    setFont(gainFont);
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (getText().equals(hint)|| getText().length()==0)
                {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                }

                else
                {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }
}