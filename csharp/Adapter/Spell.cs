using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPatterns.Adapter
{
    public interface HolySpell
    {
        void HolySpell();
    }

    public interface MagicSpell
    {
        void MagicSpell();
    }
}
