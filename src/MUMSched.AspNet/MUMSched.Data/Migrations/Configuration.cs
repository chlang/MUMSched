namespace MUMSched.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<MUMSched.Data.MumSchedDbContext>
    {
        internal static Predicate<MumSchedDbContext> TestBlank;
        internal static Action<MumSchedDbContext> SeedAction;

        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(MUMSched.Data.MumSchedDbContext context)
        {
            if (TestBlank != null &&
                SeedAction != null &&
                TestBlank(context))
            {
                SeedAction(context);
            }
        }
    }
}
