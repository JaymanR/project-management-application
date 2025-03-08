var chartDataStr = decodeHtml(chartData);
//console.log(chartDataStr);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
	numericData[i] = chartJsonArray[i].stageCount;
	labelData[i] = chartJsonArray[i].label;
}

const ctx = document.getElementById('myPieChart');

new Chart(ctx, {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: 'Dataset',
			backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
			data: numericData,
		}]
	},
	options: {
		plugins: {
			title: {
				display: true,
				text: "Project Statuses",
			}
		}
	}
});

// [{"value": 1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"}, {"value": 2, "label": "NOTSTARTED"}]
function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}