const URL = "http://localhost:8080";

const btnLoad = document.querySelector(".btn-load");
const boardContainer = document.getElementById("board-container");

const overlay = document.querySelector("#overlay");
const modalName = document.querySelector("#modal-top-name")
const modalText = document.querySelector(".modal-text-edit");

const save = document.querySelector(".save");
let modalTask;
save.addEventListener("click", () => {
    modalTask.description = modalText.textContent;
    updateTask(modalTask);
    clear();
});


btnLoad.addEventListener("click", loadBoard);


let board;
let loaded = false;

async function loadBoard() {
    let board = await fetchBoard(1);
    let pillars = board.pillars;


        for (let i = 0; i < pillars.length; i++) {
            let name = pillars[i].name;



            const pillarContainerDiv = document.createElement("div");
            const pillarNameDiv = document.createElement("div");
            const pillarContentDiv = document.createElement("div");
//
            pillarNameDiv.textContent = name;
//
            pillarNameDiv.classList.add("pillar-name");
            pillarContainerDiv.appendChild(pillarNameDiv);

            pillarContentDiv.classList.add("pillar-content");


            pillarContainerDiv.appendChild(pillarContentDiv);

            let tasks = pillars[i].tasks;

            for (let j = 0; j < tasks.length; j++) {
                const taskDiv = document.createElement("div");



                const taskHeaderDiv = document.createElement("div");
                const taskHeaderArrowDivL = document.createElement("button");
                const taskHeaderTextDiv = document.createElement("div");
                const taskHeaderArrowDivR = document.createElement("button");

                taskHeaderArrowDivL.addEventListener("click", () => {
                    shiftTask(tasks[j], pillars[i-1].pillarId);
                });
                taskHeaderArrowDivR.addEventListener("click", () => {
                    shiftTask(tasks[j], pillars[i+1].pillarId);


                });

                const taskTextDiv = document.createElement("div");
                const taskScoreDiv = document.createElement("div")

                taskTextDiv.addEventListener("click", () => {
                    overlay.style.display = "block";
                    modalTask = tasks[j];
                    modalText.textContent = tasks[j].description;
                });

                taskHeaderTextDiv.textContent = tasks[j].name;
                taskHeaderArrowDivL.textContent = "<";
                taskHeaderArrowDivR.textContent = ">";

                taskTextDiv.textContent = tasks[j].description;
                taskScoreDiv.textContent = "-1";

                taskDiv.classList.add("task-container");
                taskHeaderDiv.classList.add("task-header-container");
                taskHeaderArrowDivL.classList.add("task-header-arrow");
                taskHeaderArrowDivR.classList.add("task-header-arrow");
                taskHeaderTextDiv.classList.add("task-header-text");
                taskTextDiv.classList.add("task-text");
                taskScoreDiv.classList.add("task-score");

                taskHeaderDiv.appendChild(taskHeaderArrowDivR);
                taskHeaderDiv.appendChild(taskHeaderTextDiv);
                taskHeaderDiv.appendChild(taskHeaderArrowDivL);


                taskDiv.appendChild(taskHeaderDiv);
                taskDiv.appendChild(taskTextDiv);
                taskDiv.appendChild(taskScoreDiv);

                pillarContentDiv.appendChild(taskDiv);
            }

            pillarContainerDiv.classList.add("pillar-container");
            boardContainer.appendChild(pillarContainerDiv);
        }



}

document.querySelector(".close").addEventListener("click", () => {
    overlay.style.display = "none";
});


function fetchBoard(id) {
    return fetch(URL + "/board/" + id).then(res => res.json());
}

async function updateTask(task) {

    const fetchOptions = {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(task)
    }

    await fetch(URL + "/task/update", fetchOptions).catch(err => console.log(err));

}

function shiftTask(task, next) {
    task.pillarId = next;
    updateTask(task);
    clear();
}

async function clear() {
    document.getElementById("board-container").innerHTML = "";
    loaded = false;
    await sov(50);
    await loadBoard();

}

function createPillar(pillar) {

}

function sov(ms) {
    return new Promise(func => setTimeout(func, ms));
}