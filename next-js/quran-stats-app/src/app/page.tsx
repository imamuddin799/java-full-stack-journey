import { generalStats, pauseMarks } from '../data/quran-stats';
import StatsTable from '../components/StatsTable';

export default function Home() {
  return (
    <div>
      <h1 className="text-4xl font-bold text-center mb-12 text-gray-800">Quran Statistics</h1>

      <div className="grid md:grid-cols-2 gap-8 mb-12">
        <section>
          <h2 className="text-2xl font-semibold mb-6 text-blue-600">General Statistics</h2>
          <StatsTable data={generalStats} />
        </section>

        <section>
          <h2 className="text-2xl font-semibold mb-6 text-green-600">Pause Marks</h2>
          <StatsTable data={pauseMarks.map(p => ({ category: p.symbol, value: p.count } as any))} />
        </section>
      </div>
    </div>
  );
}
