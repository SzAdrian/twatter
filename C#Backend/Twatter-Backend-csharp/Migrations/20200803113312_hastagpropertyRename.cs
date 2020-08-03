using Microsoft.EntityFrameworkCore.Migrations;

namespace Twatter_Backend_csharp.Migrations
{
    public partial class hastagpropertyRename : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "TweetId",
                table: "hashtags",
                newName: "tweetId");

            migrationBuilder.RenameColumn(
                name: "Name",
                table: "hashtags",
                newName: "name");

            migrationBuilder.RenameColumn(
                name: "Date",
                table: "hashtags",
                newName: "date");

            migrationBuilder.RenameColumn(
                name: "Id",
                table: "hashtags",
                newName: "id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "tweetId",
                table: "hashtags",
                newName: "TweetId");

            migrationBuilder.RenameColumn(
                name: "name",
                table: "hashtags",
                newName: "Name");

            migrationBuilder.RenameColumn(
                name: "date",
                table: "hashtags",
                newName: "Date");

            migrationBuilder.RenameColumn(
                name: "id",
                table: "hashtags",
                newName: "Id");
        }
    }
}
