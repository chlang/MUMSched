using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MUMSched.Data.Migrations;

namespace MUMSched.Data
{
    public static class MumSchedDbContextManager
    {
        public static void Init(Predicate<MumSchedDbContext> testBlank,
            Action<MumSchedDbContext> seedingAction,
            Action<MumSchedDbContext> readyAction)
        {
            Configuration.TestBlank = testBlank;
            Configuration.SeedAction = seedingAction;

            Database.SetInitializer(
                new MigrateDatabaseToLatestVersion<MumSchedDbContext,
                Configuration>());

            using (var db = new MumSchedDbContext())
            {
                if (readyAction != null)
                    readyAction(db);

                else if (seedingAction != null)
                    testBlank(db);
            }
        }
    }
}
