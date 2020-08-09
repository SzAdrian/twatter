using Microsoft.EntityFrameworkCore.Migrations;

namespace Twatter_Backend_csharp.Migrations
{
    public partial class hastagpropertyRename2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "tweetId",
                table: "hashtags",
                newName: "tweetid");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "tweetid",
                table: "hashtags",
                newName: "tweetId");
        }
    }
}
