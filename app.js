const express = require('express')
const bodyParser = require('body-parser');
const app = express();
var _ = require('lodash');

const mongoose = require('mongoose');
const { Schema } = mongoose;
mongoose.connect("mongodb://localhost:27017/Todolistdb", () => {
    console.log("Connected to database successfully!")
})

const itemschema = new Schema({
    name: {
        type: String,
    }
})
// const listschema = new Schema({
//     name:{
//         type:String, 
//     }, 

// })
const Item = mongoose.model("Allitem", itemschema);


const addItems = (newitem, id) => {
    const Newitem = new Item({
        name: newitem,
    })
    if (id == "Today") {
        Newitem.save();
    } else {
        List.findOne({ name: id }, (err, foundList) => {
            if (err) {
                console.log(err);
            } else {
                foundList.items.push(Newitem);
                foundList.save();
            }
        })
    }

}
const deleteItem = (ID, listName) => {
    if (listName == "Today") {
        Item.deleteOne({ _id: ID }, (err) => {
            if (err) {
                console.log(err);
            } else {
                console.log("Item Deleted Successfully!")
            }
        });
    } else {
        console.log(ID);

        List.findOneAndUpdate({ name: listName }, { $pull: {items: { _id: ID}}}, (err) => {
            if (err) {
                console.log(err);
            } 
        });
    }

}
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));


app.get("/", (req, res) => {
    let itemss = [];
    Item.find((err, foundItems) => {
        if (err) {
            console.log(err);
        } else {
            res.render("list", { kindofDay: "Today", newItems: foundItems });
        }
    })

})

const listSchema = new Schema({
    name: {
        type: String,
    },
    items: {
        type: [itemschema],
    }
})
const List = mongoose.model("List", listSchema);
app.get("/:Customlist", (req, res) => {

    const id = _.capitalize(req.params.Customlist);
    List.findOne({ name: id }, (err, foundlist) => {
        if (err) {
            console.log(err);
        } else {
            if (!foundlist) {
                const newlist = new List({
                    name: id,
                    items: [],
                })
                newlist.save();
                res.redirect("/" + id);
            } else {
                res.render("list", { kindofDay: id, newItems: foundlist.items })
            }
        }
    })
})
app.listen(8000, () => {
    console.log("Connected Successfully!");
})

app.post("/", (req, res) => {
    const id = req.body.button;
    var newitem = req.body.newitem;

    addItems(newitem, id);
    console.log(req.body);
    if (id == "Today") {
        res.redirect("/");
    } else {

        res.redirect("/" + id);
    }

})


app.post("/delete", (req, res) => {
    const listName = req.body.Listname;
    console.log(req.body);
    deleteItem(req.body.Checkbox, listName);
    if (listName == "Today") {
        res.redirect("/");
    } else {
        res.redirect("/" + listName);
    }

})

app.get("/about", (req, res) => {
    res.render("about");
})