const functions = require('firebase-functions');
var unirest = require('unirest');


 exports.randomRecipes = functions.https.onRequest((request, response) => {
    var recipes = [];

    unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/random?limitLicense=true&number=5")
        .header("X-Mashape-Key", "JBRjR9pfv7mshQMWrrdIougB95C6p1bAqKDjsnFDLS8xuwYZjB")
        .header("Accept", "application/json")
        .end(function (result) {
            console.log(result)
            if (result.status === 200) {
                recipes = result.body.recipes;
            }
            response.send(recipes);
        });
 });
