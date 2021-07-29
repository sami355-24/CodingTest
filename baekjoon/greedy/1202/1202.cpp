#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

const int MAX = 300000;

int N, K;
int bag[MAX];
pair <int, int> gem[MAX];
priority_queue <int> pq;




int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> K;
	for (int i=0; i < N; i++)
		cin >> gem[i].first >> gem[i].second;

	for (int i = 0; i < K; i++)
		cin >> bag[i];

	sort(gem, gem + N);
	sort(bag, bag + K);

	long long result = 0;
	int idx = 0;
	for (int i=0; i < K; i++)
	{
		while (idx < N && gem[idx].first <= bag[i])
			pq.push(gem[idx++].second);
		
		if (!pq.empty())
		{
			result+=pq.top();
			pq.pop();
		}
	}

	cout << result << "\n";
	return 0;
}