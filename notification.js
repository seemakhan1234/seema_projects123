class add2kart {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Public functions
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Shows a added, handles the multiple arguments combination. To see more about the possible combination, see
     * [the documentation](https://github.com/paper-development/vanilla-addeds).
     */
    static show() {
        /*********** <Parsing arguments> ***********/
        let args;
        try {
            args = add2kart._parseArgs(arguments);
        } catch (exception) {
            throw exception;
        }

        let content = args["content"];
        let title = args["title"];
        let options = args["options"];
        /*********** </Parsing arguments> ***********/

        /*********** <Showing the added> ***********/
        try {
            add2kart._show(title, content, options)
        } catch (exception) {
            throw exception;
        }
        /*********** </Showing the added> ***********/
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Private functions
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Shows a added.
     * @param title The added title
     * @param text The added text
     * @param options The added options
     * @private
     */
    static _show(title, text, options) {

        /*********** <DOM Elements creation> ***********/
        let added = add2kart._createaddedElement(title, text, options)
        document.documentElement.append(added);
        /*********** </DOM Elements creation> ***********/

        /*********** <Positioning> ***********/
        let position = options["position"].split("-");
        let vPosition = position[0];
        let hPosition = position[1];

        switch (vPosition) {
            case "top":
                added.style.top = "0";
                break;
            case "middle":
                added.style.top = "calc(50vh - (" + added.offsetHeight + "px / 2) - " + options["margin"] + "px)";
                break;
            case "bottom":
                added.style.bottom = "0";
                break;
            default:
                throw "add2kart: error, unknown vertical position attribute " + vPosition + ".";
        }

        switch (hPosition) {
            case "left":
                added.style.left = "0";
                break;
            case "centre":
                added.style.left = "calc(50vw - (" + options["width"] + "px / 2) - " + options["margin"] + "px)";
                break;
            case "right":
                added.style.right = "0";
                break;
            default:
                throw "add2kart: error, unknown horizontal position attribute " + hPosition + ".";
        }
        added.style.width = options["width"] + "px";
        added.style.margin = options["margin"] + "px";
        /*********** </Positioning> ***********/

        /*********** <Appearance> ***********/
        added.style.color = options["color"];
        added.style.backgroundColor = options["backgroundcolor"];
        added.style.opacity = options["opacity"];
        /*********** </Appearance> ***********/

        /*********** <Auto-remove> ***********/
        add2kart._remove(added, options["duration"]);

        // Mouse enter event, we must stop the auto-remove process
        added.addEventListener("mouseenter", function () {

            //Clearing the timeout on the added
            add2kart._cancelRemove(added);

            // Stopping the progress bar width animation by setting the width to the current width
            if (added.progressbarType !== "hidden")
                added.progressbarElement.style.width = added.progressbarElement.clientWidth + "px";
        });

        // Mouse leave event, we must restart the auto-remove process
        added.addEventListener("mouseleave", function () {

            //Resetting width and adapting transition duration
            if (added.progressbarType !== "hidden") {
                window.requestAnimationFrame(function () {
                    added.progressbarElement.style.transition = "width " + (options["unfocusduration"] / 1000) + "s linear";
                    added.progressbarElement.style.width = "0";
                });
            }

            //Setting a timeout to remove the added after the delay is over.
            add2kart._remove(added, options["unfocusduration"]);
        });
        /*********** </Auto-remove> ***********/

        /*********** <Progressbar animation> ***********/
        if (added.progressbarType !== "hidden") {
            window.requestAnimationFrame(function () {
                added.progressbarElement.style.transition = "width " + (options["duration"] / 1000) + "s linear";
                added.progressbarElement.style.width = "0";
            });
        }
        /*********** </Progressbar animation> ***********/

        /*********** <Moving other addeds out of the way> ***********/
        for (let added of add2kart.addeds[vPosition + "-" + hPosition]) {
            if (vPosition === "top") {
                let currentTop = added.style.top;
                added.style.top = (Number(currentTop.substring(0, currentTop.length - 2)) + added.offsetHeight + options["margin"]) + "px";
            } else if (vPosition === "middle") {
                let currentTop = added.style.top;
                added.style.top = currentTop.substring(0, currentTop.length - 1) + " + " + (added.offsetHeight + options["margin"]) + "px)";
            } else if (vPosition === "bottom") {
                let currentBottom = added.style.bottom;
                added.style.bottom = (Number(currentBottom.substring(0, currentBottom.length - 2)) + added.offsetHeight + options["margin"]) + "px";
            }
        }
        /*********** </Moving other addeds out of the way> ***********/

        /*********** <Finishing> ***********/
        //Showing the added
        window.requestAnimationFrame(function () {
            added.classList.remove("hidden");
        });

        //Adding the added in the added list
        add2kart.addeds[vPosition + "-" + hPosition].push(added);
        /*********** </Finishing> ***********/
    }

    /**
     * Creates a added DOM element ready to be used.
     * What is done, in details: Elements hierarchy creation, classes addition, progressbar & close button.
     * What is **not** done: All options, except for the close button and the progressbar.
     * @param title The added title
     * @param text The added text
     * @param options The added options
     * @returns {HTMLDivElement}
     * @private
     */
    static _createaddedElement(title, text, options) {

        let addedContainer = document.createElement("div");
        let contentContainer = document.createElement("div")
        let titleContainer = document.createElement("span");

        if (options["showclose"]) {
            let closeButtonElement = document.createElement("i");
            closeButtonElement.classList.add("close-button");
            addedContainer.closeButtonElement = closeButtonElement;
        }

        if (options["progressbar"] !== "hidden") {
            let progressBarElement = document.createElement("div");
            progressBarElement.classList.add("progressbar");
            addedContainer.progressbarElement = progressBarElement;
            addedContainer.progressbarType = options["progressbar"];
        }

        addedContainer.classList.add("add2kart", "hidden");
        contentContainer.classList.add("content");
        titleContainer.classList.add("title");

        if (options["showclose"])
            addedContainer.append(addedContainer.closeButtonElement);

        if (options["progressbar"] === "top")
            addedContainer.append(addedContainer.progressbarElement);

        titleContainer.innerHTML = title;
        contentContainer.append(titleContainer);
        contentContainer.innerHTML += text;

        addedContainer.append(contentContainer);

        if (options["progressbar"] === "bottom")
            addedContainer.append(addedContainer.progressbarElement);

        return addedContainer;
    }

    /**
     * Parses the arguments for the show method.
     * @param args The argument array
     * @returns An object containing the content, title and options with the keys in the previously given order.
     * @private
     */
    static _parseArgs(args) {
        /*********** <Default values> ***********/
        let title = "";
        let content = "";
        let options = add2kart.options;
        /*********** </Default values> ***********/


        /*********** <Parsing arguments> ***********/
        if (args.length === 1) {
            content = args[0];
        } else if (args.length === 2) {
            title = args[0];
            content = args[1];
        } else if (args.length === 3) {
            title = args[0];
            content = args[1];
            options = {...options, ...args[2]};
        } else {
            throw "add2kart: error, incorrect argument count, expected 1, 2 or 3. " + args.length + " given.";
        }
        /*********** </Parsing arguments> ***********/

        return {
            "content": content,
            "title": title,
            "options": options
        };
    }

    /**
     * Removes a added.
     * @param added The added to remove.
     * @param delay The delay (in ms) before the removal.
     * @private
     */
    static _remove(added, delay) {
        added.removeTimeout = setTimeout(function () {
            added.classList.add("hidden");

            setTimeout(function () {
                added.remove();
            }, 700);
        }, delay);
    }

    /**
     * Cancels a added removal.
     * @param added The added to cancel the removal on.
     * @private
     */
    static _cancelRemove(added) {
        clearTimeout(added.removeTimeout);
    }
}

// This property holds all the addeds
add2kart.addeds = {
    "top-left": [], "top-centre": [], "top-right": [],
    "middle-left": [], "middle-centre": [], "middle-right": [],
    "bottom-left": [], "bottom-centre": [], "bottom-right": [],
};

// Default options
add2kart.options = {
    "width": 170,
    "margin": 10,
    "color": "white",
    "backgroundcolor": "#192537",
    "duration": 5000,
    "unfocusduration": 1000,
    "position": "bottom-right",
    "showclose": false,
    "progressbar": "hidden",
    "opacity": "1"
};